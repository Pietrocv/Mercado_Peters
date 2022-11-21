function logar() {
    const UserSenha = document.getElementById("senha").value
    const UserEmail = document.getElementById("email").value

    if (UserSenha.length > 20) {
        return Toastify({
            text: "Senha inválida",
            duration: 3000,
            style: {background: "red"}
        }).showToast();
    }


    const data = {
        email: UserEmail, password: UserSenha
    }
    let url = "http://localhost:8080/login"
    fetch(url, {
        method: "POST",
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(data)
    }).then(response => response.json())
        .then(response => {
            console.log(response)
            if (response) {
                return window.location.href = '/menu'
            }
        })
}
