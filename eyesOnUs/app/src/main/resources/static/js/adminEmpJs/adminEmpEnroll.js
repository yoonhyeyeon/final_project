document.addEventListener('DOMContentLoaded', function() {
    const idField = document.getElementById('id');
    const nickField = document.getElementById('nick');
    const pwdField = document.getElementById('pwd');
    const pwdCheckField = document.getElementById('pwdCheck');
    const form = document.querySelector('form');

    // 아이디 검증
    idField.addEventListener('blur', function() {
        const idValue = this.value;
        const idEqualError = document.getElementById('joinCheckIdEqual');
        const idLengthError = document.getElementById('joinCheckIdLength');
        const idFormatError = document.getElementById('joinCheckIdIsEngNum');
        const idContainsAdminError = document.getElementById('joinCheckIdContainsAdmin');

        idEqualError.classList.add('hide');
        idLengthError.classList.add('hide');
        idFormatError.classList.add('hide');
        idContainsAdminError.classList.add('hide');

        if (idValue.length < 4 || idValue.length > 12) {
            idLengthError.classList.remove('hide');
        } else if (!/^[a-zA-Z0-9]+$/.test(idValue)) {
            idFormatError.classList.remove('hide');
        } else if (/.*(admin|ADMIN).*/.test(idValue)) {
            idContainsAdminError.classList.remove('hide');
        } else {
            // 아이디 중복 검사
            $.ajax({
                url: '/adminEmpMngr/checkId',
                method: 'POST',
                data: { id: idValue },
                success: function(response) {
                    if (response.exists) {
                        idEqualError.classList.remove('hide');
                    }
                },
                error: function() {
                    alert('아이디 중복 검사에 실패했습니다.');
                }
            });
        }
    });

    // 닉네임 검증
    nickField.addEventListener('blur', function() {
        const nickValue = this.value;
        const nickError = document.getElementById('joinCheckNick');

        nickError.classList.add('hide');

        // 닉네임 검증 로직 추가 (예: 최소 길이, 특수문자 여부 등)
        if (nickValue.length === 0) {
            nickError.textContent = '닉네임을 입력해주세요.';
            nickError.classList.remove('hide');
        } else if (/.*(admin|ADMIN).*/.test(nickValue)) {
            nickError.textContent = '닉네임에 "admin"을 포함할 수 없습니다.';
            nickError.classList.remove('hide');
        }
    });

    // 비밀번호 검증
    pwdField.addEventListener('blur', function() {
        const pwdValue = this.value;
        const pwdError = document.getElementById('joinCheckPwd');

        pwdError.classList.add('hide');

        const pwdPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,20}$/;
        if (!pwdPattern.test(pwdValue)) {
            pwdError.classList.remove('hide');
        }
    });

    // 비밀번호 확인 검증
    pwdCheckField.addEventListener('blur', function() {
        const pwdValue = document.getElementById('pwd').value;
        const pwdCheckValue = this.value;
        const pwdCheckError = document.getElementById('joinCheckPwdEqual');

        pwdCheckError.classList.add('hide');

        if (pwdValue !== pwdCheckValue) {
            pwdCheckError.textContent = '비밀번호가 일치하지 않습니다.';
            pwdCheckError.classList.remove('hide');
        }
    });

    // 폼 제출 시 빈칸 검사
    form.addEventListener('submit', function(event) {
        const requiredFields = form.querySelectorAll('input[type="text"], input[type="date"], input[type="password"]');
        let hasEmptyField = false;

        requiredFields.forEach(function(field) {
            if (!field.value.trim()) {
                hasEmptyField = true;
                field.classList.add('input-error');
            } else {
                field.classList.remove('input-error');
            }
        });

        if (hasEmptyField) {
            alert('빈 칸을 입력해주세요.');
            event.preventDefault(); // 폼 제출을 막습니다.
        }
    });
});
