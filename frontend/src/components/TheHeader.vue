<template>
    <header>
        <div class="container">
            <h1>
                <img src="../assets/logo.png" alt="">
            </h1>
        </div>
    </header>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
    name: 'TheHeader'
})
</script>

<style scoped>
header {
    background: #7b0000;
    width: 100%;
    height: 15vh;
}
</style>