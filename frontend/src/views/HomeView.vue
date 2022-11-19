<template>
  <main class="home">
    <div class="container">
      <div class="row row-cols-2 row-cols-md-3 g-4">
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title"><RouterLink to="/livros">Acervo de Livros</RouterLink></h5>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title"><RouterLink to="/usuarios">Usuários</RouterLink></h5>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title"><RouterLink to="/leitores">Leitores</RouterLink></h5>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title"><RouterLink to="/locacao">Locação</RouterLink></h5>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title"><RouterLink to="/devolucao">Devolução</RouterLink></h5>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title"><RouterLink to="/entregas-pendentes">Entregas Pendentes</RouterLink></h5>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'HomeView',
  props: {
  },
});
</script>

<style lang="scss">
</style>
