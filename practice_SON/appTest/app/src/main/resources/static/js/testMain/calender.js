const { google } = require('googleapis');
const fs = require('fs');
const readline = require('readline');

const TOKEN_PATH = 'token.json'; // 토큰 저장 경로

// 클라이언트 정보 로드
const credentials = require('path/to/your/client_secret.json'); // 클라이언트 시크릿 파일 경로

// 구글 OAuth2 클라이언트 설정
const { client_secret, client_id, redirect_uris } = credentials.installed;
const oAuth2Client = new google.auth.OAuth2(
    client_id, client_secret, redirect_uris[0]
);

// 토큰 로드 함수
function loadToken() {
    try {
        const token = fs.readFileSync(TOKEN_PATH);
        oAuth2Client.setCredentials(JSON.parse(token));
    } catch (err) {
        return getAccessToken(oAuth2Client);
    }
}

// 토큰 획득 함수
function getAccessToken(oAuth2Client) {
    const authUrl = oAuth2Client.generateAuthUrl({
        access_type: 'offline',
        scope: ['https://www.googleapis.com/auth/calendar'],
    });
    console.log('인증 URL:', authUrl);
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
    });
    rl.question('위의 URL을 방문하고 인증 코드를 입력하십시오: ', (code) => {
        rl.close();
        oAuth2Client.getToken(code, (err, token) => {
            if (err) return console.error('토큰을 가져오는 데 문제가 발생했습니다.', err);
            oAuth2Client.setCredentials(token);
            fs.writeFileSync(TOKEN_PATH, JSON.stringify(token));
        });
    });
}

// 메인 함수
function main() {
    loadToken();
    const calendar = google.calendar({ version: 'v3', auth: oAuth2Client });
    calendar.events.list({
        calendarId: 'primary',
        timeMin: (new Date()).toISOString(),
        maxResults: 10,
        singleEvents: true,
        orderBy: 'startTime',
    }, (err, res) => {
        if (err) return console.error('API 호출 오류:', err);
        const events = res.data.items;
        if (events.length) {
            console.log('다음 이벤트를 찾았습니다:');
            events.map((event, i) => {
                const start = event.start.dateTime || event.start.date;
                console.log(`${start} - ${event.summary}`);
            });
        } else {
            console.log('다음 몇 가지 이벤트가 없습니다.');
        }
    });
}

main();
