<template>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col d-flex">
                    <img src="" alt="">
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
    name: 'FooterPrincipal'
})
</script>

<style scoped>
footer {
    background: #7b0000;
    width: 100%;
    height: 15vh;
}
img {
    width: 20%;
    height: 100%;
}
</style>