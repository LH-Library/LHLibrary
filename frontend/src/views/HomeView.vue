<template>
  <main class="home">
    <div class="container">
      <div class="row row-cols-2 row-cols-md-3 g-4">
        <div class="col">
          <RouterLink to="/livros">
            <div class="card">
              <div class="card-body">
                <div class="card-icon">
                  <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 122.88 99.45" style="enable-background:new 0 0 122.88 99.45" xml:space="preserve"><g><path class="st0" d="M64.48,0.38h18.42c1.85,0,3.36,1.51,3.36,3.36v14.84H61.12V3.74C61.12,1.89,62.63,0.38,64.48,0.38L64.48,0.38z M86.27,27.65v45.19H61.12V27.65H86.27L86.27,27.65z M86.27,81.92v13.8c0,1.85-1.51,3.36-3.36,3.36H64.48 c-1.85,0-3.36-1.51-3.36-3.36v-13.8H86.27L86.27,81.92z"/><path class="st0" d="M101.09,0.38h18.42c1.85,0,3.36,1.51,3.36,3.36v14.84h-0.02H97.73V3.74C97.73,1.89,99.25,0.38,101.09,0.38 L101.09,0.38z M122.88,27.65v45.19H97.73V27.65h25.13H122.88L122.88,27.65z M122.88,81.92v13.8c0,1.85-1.51,3.36-3.36,3.36h-18.42 c-1.85,0-3.36-1.51-3.36-3.36v-13.8H122.88L122.88,81.92z"/><path class="st0" d="M35.95,0.2l17.31,6.3c1.74,0.63,2.64,2.57,2.01,4.31L50.2,24.75l-23.63-8.6l5.07-13.94 C32.28,0.47,34.22-0.43,35.95,0.2L35.95,0.2z M47.1,33.28L31.65,75.75l-23.63-8.6l15.45-42.46L47.1,33.28L47.1,33.28z M28.55,84.28 l-4.72,12.96c-0.63,1.74-2.57,2.64-4.31,2.01l-17.31-6.3c-1.74-0.63-2.64-2.57-2.01-4.31l4.72-12.96L28.55,84.28L28.55,84.28z"/></g></svg>
                </div>
                <h5 class="card-title">Livros</h5>
              </div>
            </div>
          </RouterLink>
        </div>
        <!-- <div class="col">
          <RouterLink to="/usuarios">
            <div class="card">
              <div class="card-body">
                <div class="card-icon">
                  <font-awesome-icon icon="fa-solid fa-users" />
                </div>
                <h5 class="card-title">
                  Usuários
                </h5>
              </div>
            </div>
          </RouterLink>
        </div> -->
        <div class="col">
          <RouterLink to="/leitores">
            <div class="card">
              <div class="card-body">
                <div class="card-icon">
                  <font-awesome-icon icon="fa-solid fa-book-open-reader" />
                </div>
                <h5 class="card-title">Leitores</h5>
              </div>
            </div>
          </RouterLink>
        </div>
        <div class="col">
          <RouterLink to="/locacao">
            <div class="card">
              <div class="card-body">
                <div class="card-icon">
                  <svg xmlns="http://www.w3.org/2000/svg" shape-rendering="geometricPrecision" text-rendering="geometricPrecision" image-rendering="optimizeQuality" fill-rule="evenodd" clip-rule="evenodd" viewBox="0 0 479 511.83"><path d="M219.08 0h197.57v226.67c-.36 6.16-8.32 6.3-16.92 5.92H216.16c-11.88 0-21.6 9.72-21.6 21.62 0 11.89 9.72 21.61 21.6 21.61h191.48v-23h16.91v29.24c0 5.32-4.34 9.66-9.68 9.66H217.01c-27.07 0-38.91-9.57-38.91-30.97V40.98C178.1 18.44 196.53 0 219.08 0zM6.73 300.41h82.33c3.7 0 6.73 3.03 6.73 6.73v159.27c0 3.71-3.03 6.73-6.73 6.73H6.73c-3.7 0-6.73-3.02-6.73-6.73V307.14c0-3.7 3.03-6.73 6.73-6.73zm110.4 158.79V315.82c70.69 1.65 84.62-1.24 147.39 40.35l50.09 1.17c22.64 1.89 33.98 25.15 11.61 39.74-17.88 12.46-41.03 11.19-64.73 8.51-16.36-1.18-17.59 20.81-.49 21.29 5.92.6 12.4-.64 18.04-.52 29.65.66 54.2-4.44 69.69-27.51l7.92-17.35 75.37-35.21c37.57-11.41 63.15 28.21 35.06 54.69-54.88 38.01-110.99 69.04-168.2 93.81-41.69 24.05-82.79 22.24-123.34-2.87l-58.41-32.72z"/></svg>
                </div>
                <h5 class="card-title">Locação</h5>
              </div>
            </div>
          </RouterLink>
        </div>
        <!-- <div class="col">
          <RouterLink to="/devolucao">
            <div class="card">
              <div class="card-body">
                <div class="card-icon">
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                    class="bi bi-people" viewBox="0 0 16 16">
                    <path
                      d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8Zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022ZM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816ZM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275ZM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0Zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4Z" />
                  </svg>
                </div>
                <h5 class="card-title">
                  Devolução
                </h5>
              </div>
            </div>
          </RouterLink>
        </div> -->
        <!-- <div class="col">
          <RouterLink to="/entregas-pendentes">
            <div class="card">
              <div class="card-body">
                <div class="card-icon">
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                    class="bi bi-people" viewBox="0 0 16 16">
                    <path
                      d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8Zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022ZM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816ZM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275ZM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0Zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4Z" />
                  </svg>
                </div>
                <h5 class="card-title">
                  Em atraso
                </h5>
              </div>
            </div>
          </RouterLink>
        </div> -->
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

<style lang="scss" scoped>
a {
  color: #2e2d2d;
  text-decoration: none;

  &:hover {
    color: #920000;
  }
}

svg {
  width: 40px !important;
  height: 40px !important;
}

.card {
  height: 100px;
}

.card-body {
  display: flex;
  justify-content: center;

  * {
    margin: 0 .5rem;
  }
}

.card-title {
  display: flex;
  align-items: center;
  margin-left: 2rem;
  font-size: 1.4rem;
  vertical-align: center;
  line-height: 1.7;
  width: 70%
}

.card-icon {
  margin-left: 2rem;
  display: flex;
  align-items: center;
  width: 30%;
}
</style>
