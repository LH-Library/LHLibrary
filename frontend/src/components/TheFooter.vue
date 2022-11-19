<template>
    <footer>
        <div class="container">
            <div class="row py-4">
                <div class="col px-5 border-end border-2">
                    <img src="../assets/logo-prefeitura.png" alt="">
                    <p>Biblioteca Pública da Prefeitura Municipal de Brás Cubas</p>
                </div>
                <div class="col"><p>Powered by LH Technology Company</p></div>
            </div>
        </div>
    </footer>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
    name: 'TheFooter'
})
</script>

<style scoped>
footer {
    background: #7b0000;
    width: 100%;
    font-size: 1.2rem;
    color: #ffffff;
    height: 13vh;
}
img {
    width: 20%;
    height: 100%;
}
p{
    margin: 0;
    vertical-align: middle;
}

div.col{
    display: flex;
    justify-content: space-around;
    align-items: center;
}
</style>