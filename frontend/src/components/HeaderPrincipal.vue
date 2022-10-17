<template>
    <header>
        <div class="container">
            <h1>
                <img src="../assets/logo.png" alt="">
            </h1>
        </div>
    </header>
    <nav class="navbar navbar-expand-lg"> 
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Livros</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Usuários</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Leitores</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Locação</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Devolução</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Entregas Pendentes</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
    name: 'HeaderPrincipal'
})
</script>

<style scoped>
    header {
        background: #7b0000;
        width: 100%;
        height: 15vh;
    }
    nav {
        background: #920000
    }
</style>