<template>
  <main class="container-fluid p-0">
    <HeaderPrincipal />
    <FooterPrincipal />
  </main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import HeaderPrincipal from './components/HeaderPrincipal.vue';
import FooterPrincipal from './components/FooterPrincipal.vue';

export default defineComponent({
    name: 'App',
    components: { HeaderPrincipal, FooterPrincipal }
});
</script>

<style>

</style>