function voltar(){
    window.location.href = "/menu"
}
window.addEventListener("load", () => {
    lista_produto = document.getElementById('lista_produtos');
    fetch("cadastro_produto/lista_produtos").then(res => res.json()).then((res) => {
        lista_produto.innerHTML = res.map((produto, index) => `<p><div>Nome:${produto.name_produto}, 
        Preço: ${produto.preco_produto}, Categoria: ${produto.name_categoria}, Data Validade: ${produto.data_validade}
        :</div></p>`).join(" ")
    })
})
