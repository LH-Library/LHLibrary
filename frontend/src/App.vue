<template>
<TheHeader />
<nav class="navbar navbar-dark navbar-expand-lg"> 
  <div class="container-fluid">
      <div class="collapse navbar-collapse justify-content-center" id="navbarNavDropdown">
          <ul class="navbar-nav justify-content-between w-100 mx-5">
              <li class="nav-item">
                <RouterLink class="nav-link" to="/">
                  <font-awesome-icon icon="fa-solid fa-house" />
                </RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link" to="/livros">Livros</RouterLink>
              </li>
              <!-- <li class="nav-item">
                <RouterLink class="nav-link"  to="/usuarios">Usuários</RouterLink>
              </li> -->
              <li class="nav-item">
                <RouterLink class="nav-link"  to="/leitores">Leitores</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link"  to="/locacao">Locação</RouterLink>
              </li>
              <!-- <li class="nav-item">
                <RouterLink class="nav-link"  to="/devolucao">Devolução</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link" to="/entregas-pendentes">Entregas Pendentes</RouterLink>
              </li> -->
              <li class="nav-item">
                <RouterLink class="nav-link" to="#">
                  <font-awesome-icon icon="fa-solid fa-user" />
                </RouterLink>
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
  }
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
  font-size: 1.2rem;
  height: 5vh;

  svg {
    width: 30px;
    height: 30px;
  }

  a {
    font-weight: bold;
    color: #ffffff!important;

    &.RouterLink-exact-active {
      color: #42b983;
    }
  }
}
main {
  min-height: 67vh;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  padding: 3rem 0;
}

tbody {
    th {
        font-weight: 500;
    }
}
</style>
