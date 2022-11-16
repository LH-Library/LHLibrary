<template>
    <form id="form-new-book">
        <div class="row">
            <div class="col">
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="titulo">Título</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="titulo" id="titulo" v-model="form.titulo" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="autor">Autor</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="autor" id="autor" v-model="form.autor" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="editora">Editora</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="editora" id="editora" v-model="form.editora" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="edicao">Edição</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="edicao" id="edicao" v-model="form.edicao" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="idioma">Idioma</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="idioma" id="idioma" v-model="form.idioma" type="text">
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="paginas">Páginas</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="paginas" id="paginas" v-model="form.paginas" type="number">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="genero">Gêneros</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="genero" id="genero" v-model="form.genero" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="isbn">ISBN</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="isbn" id="isbn" v-model="form.isbn" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="local">Local</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="local" id="local" v-model="form.local" type="text">
                    </div>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-danger mt-5" v-if="form.id !== undefined"
            @click="updateBook">Atualizar</button>
        <button type="submit" class="btn btn-danger mt-5" v-else @click="createBook">Enviar</button>
        <RequestAlert class="mt-3" @showAlert="returnRequestAlert" :show="showAlert" :success="alertSuccess"/>
    </form>
</template>
  
<script lang="ts">
import { defineComponent } from 'vue';
import RequestAlert from '@/components/RequestAlert.vue';

export default defineComponent({
    name: 'FormBook',
    components: { RequestAlert },
    methods: {
        goToDetailsBookPage(id: string) {
            this.$router.push({ name: 'livros-detalhes', params: { id: id } })
        },
        showRequestAlert(responseResult : boolean) {
            this.showAlert = true;
            if (!responseResult) {
                this.alertSuccess = false;
                return;
            }
            this.alertSuccess = true;
        },
        returnRequestAlert(show : boolean) {
            this.showAlert = show;
        },
        getBookInformation(id: string | string[]) {
            fetch(`http://localhost:8081/api/v1/livros/${id}`)
                .then((response) => {
                    return response.json();
                })
                .then((data) => this.form = data)
                .catch((error) => console.log(error));
        },
        createBook(e: Event) {
            e.preventDefault();
            fetch("http://localhost:8081/api/v1/livros/", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(this.form)
            })
                .then((response) => {
                    this.showRequestAlert(response.ok);
                    return response.json();
                })
                .then((data) => this.goToDetailsBookPage(data.id))
                .catch((error) => console.log(error));
        },
        updateBook(e: Event) {
            e.preventDefault();
            fetch(`http://localhost:8081/api/v1/livros/${this.form.id}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(this.form)
            })
                .then((response) => {
                    this.showRequestAlert(response.ok);
                    return response.json();
                })
                .then((data) => this.goToDetailsBookPage(data.id))
                .catch((error) => console.log(error));
        }
    },
    mounted() {
        if (this.form.id != null) {
            this.getBookInformation(this.form.id);
        }
    },
    data() {
        return {
            form: {
                id: this.$route.params.id,
                titulo: null,
                autor: null,
                editora: null,
                edicao: null,
                idioma: null,
                paginas: null,
                genero: null,
                status: "DISPONIVEL",
                isbn: null,
                ativo: true,
                local: null
            },
            showAlert: false,
            alertSuccess: false
        }
    }
});
</script>
  
<style lang="scss">

</style>
  