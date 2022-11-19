<template>
  <main class="container">
    <div class="row w-100">
      <div class="col-md-10">
        <div class="row">
          <div class="col-md-6">
            <h1 class="header-attribute">Nome:<br /><span>{{ reader.nome }}</span></h1>
          </div>
          <div class="col-md-6">
            <h5 class="header-attribute">Id:<br /><span>{{ reader.id }}</span></h5>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <h5 class="default-attribute">E-mail: <span>{{ reader.email }}</span></h5>
            <h5 class="default-attribute">Telefone: <span>{{ reader.cpf }}</span></h5>
            <h5 class="default-attribute">CPF: <span>{{ reader.cpf }}</span></h5>
          </div>
          <div class="col-md-6">
            <h5 class="default-attribute">Endereço: 
              <span>
              {{ reader.endereco.logradouro }}, Bairro {{ reader.endereco.bairro }}, Nº {{ reader.endereco.numero }},<br />
              Complemento {{ reader.endereco.complemento }}, Cidade {{ reader.endereco.cidade }},<br />
              {{ reader.endereco.cep }}
              </span>
            </h5>
          </div>
        </div>
      </div>
      <div class="col-md-2 d-flex flex-column justify-content-evenly">
        <button type="button" class="btn btn-danger" disabled>Remover</button>
        <button type="button" class="btn btn-danger" @click="goToEditBookPage" disable>Editar</button>
      </div>
    </div>
  </main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: "DetailsReaderView",
  props: {
  },
  methods: {
    getReaderInformation(id: string | string[]) {
            fetch(`http://localhost:8081/api/v1/leitor/${id}`)
                .then((response) => {
                    return response.json();
                })
                .then((data) => this.reader = data)
                .catch((error) => console.log(error));
    },
    goToEditBookPage() {
      this.$router.push({ name: 'leitores-editar', params: { id: this.reader.id } })
    }
  },
  mounted() {
    if (this.reader.id != null) {
      this.getReaderInformation(this.reader.id);
    }
  },
  data() {
    return {
      reader: {
        id: this.$route.params.id,
        nome: "",
        email: "",
        cpf: "",
        telefone: "",
        ativo: true,
        endereco: {
          id: "",
          logradouro: "",
          cep: "",
          bairro: "",
          numero: "",
          cidade: "",
          complemento: ""
        }
      },
    }
  }
});
</script>

<style lang="scss">
buttton {
  color: #7b0000;
}

.default-attribute {
  margin-top: 2rem;
  font-weight: bold;
  text-align: left;
  font-size: 1.3;

  span {
    font-weight: lighter;
    font-size: 1.2rem;
  }
}

.header-attribute {
  font-weight: bold;
  font-size: 1rem;
  text-align: left;

  span {
    font-size: 1.5rem;
    font-weight: lighter;
    color: #7b0000;
  }
}
</style>
