<template>
<TheHeader />
<nav class="navbar navbar-dark navbar-expand-lg"> 
  <div class="container-fluid">
      <div class="collapse navbar-collapse justify-content-center" id="navbarNavDropdown">
          <ul class="navbar-nav justify-content-evenly w-100">
              <li class="nav-item">
                <RouterLink class="nav-link" to="/livros">Livros</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link"  to="/usuarios">Usuários</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link"  to="/leitores">Leitores</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link"  to="/locacao">Locação</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link"  to="/devolucao">Devolução</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link" to="/entregas-pendentes">Entregas Pendentes</RouterLink>
              </li>
          </ul>
      </div>
  </div>
</nav>
<RouterView />
<TheFooter />
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import TheHeader from '@/components/TheHeader.vue';
import TheFooter from '@/components/TheFooter.vue';

export default defineComponent({
  name: 'App',
  components: {
    TheHeader,
    TheFooter
  },
});
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
  background: #920000;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.RouterLink-exact-active {
      color: #42b983;
    }
  }
}
</style>
