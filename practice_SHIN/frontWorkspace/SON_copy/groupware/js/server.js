const express = require('express');
const { google } = require('googleapis');
const fs = require('fs');
const readline = require('readline');

const app = express();
const PORT = 3000;
const TOKEN_PATH = 'client_secret_298429017150-98tgjf1g2ig8agicq5gpgj81nu4317k7.apps.googleusercontent.com.json';
const credentials = require('./path/to/your/client_secret.json');

const { client_secret, client_id, redirect_uris } = credentials.installed;
const oAuth2Client = new google.auth.OAuth2(
    client_id, client_secret, redirect_uris[0]
);

function loadToken() {
    try {
        const token = fs.readFileSync(TOKEN_PATH);
        oAuth2Client.setCredentials(JSON.parse(token));
    } catch (err) {
        getAccessToken(oAuth2Client);
    }
}

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

loadToken();

app.get('/events', (req, res) => {
    const calendar = google.calendar({ version: 'v3', auth: oAuth2Client });
    calendar.events.list({
        calendarId: 'primary',
        timeMin: (new Date()).toISOString(),
        maxResults: 10,
        singleEvents: true,
        orderBy: 'startTime',
    }, (err, response) => {
        if (err) return res.status(500).send('API 호출 오류: ' + err);
        const events = response.data.items;
        res.json(events);
    });
});

app.listen(PORT, () => {
    console.log(`서버가 http://localhost:${PORT} 에서 실행 중입니다.`);
});
