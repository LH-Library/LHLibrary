<template>
    <form id="form-new-book">
        <div class="row">
            <div class="col">
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="titulo">Título</label>
                    </div>
                    <div class="col-auto">
                        <input class="form-control" name="titulo" id="titulo" v-model="form.titulo" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="autor">Autor</label>
                    </div>
                    <div class="col-auto">
                        <input class="form-control" name="autor" id="autor" v-model="form.autor" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="editora">Editora</label>
                    </div>
                    <div class="col-auto">
                        <input class="form-control" name="editora" id="editora" v-model="form.editora" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="edicao">Edição</label>
                    </div>
                    <div class="col-auto">
                        <input class="form-control" name="edicao" id="edicao" v-model="form.edicao" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="idioma">Idioma</label>
                    </div>
                    <div class="col-auto">
                        <input class="form-control" name="idioma" id="idioma" v-model="form.idioma" type="text">
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="paginas">Páginas</label>
                    </div>
                    <div class="col-auto">
                        <input class="form-control" name="paginas" id="paginas" v-model="form.paginas" type="number">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="genero">Gêneros</label>
                    </div>
                    <div class="col-auto">
                        <input class="form-control" name="genero" id="genero" v-model="form.genero" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="isbn">ISBN</label>
                    </div>
                    <div class="col-auto">
                        <input class="form-control" name="isbn" id="isbn" v-model="form.isbn" type="text">
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="local">Local</label>
                    </div>
                    <div class="col-auto">
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
        async getBookInformation(id: string | string[]) {
            const req = await fetch(`http://localhost:8081/api/v1/livros/${id}`)
            const data = await req.json();

            console.log(data);

            this.form.titulo = data.titulo,
                this.form.autor = data.autor,
                this.form.editora = data.editora,
                this.form.edicao = data.edicao,
                this.form.idioma = data.idioma,
                this.form.paginas = data.paginas,
                this.form.genero = data.genero,
                this.form.status = data.status,
                this.form.isbn = data.isbn,
                this.form.ativo = data.ativo,
                this.form.local = data.local
        },
        async createBook(e: Event) {
            e.preventDefault();

            const data = {
                titulo: this.form.titulo,
                autor: this.form.autor,
                editora: this.form.editora,
                edicao: this.form.edicao,
                idioma: this.form.idioma,
                paginas: this.form.paginas,
                genero: this.form.genero,
                status: this.form.status,
                isbn: this.form.isbn,
                ativo: this.form.ativo,
                local: this.form.local
            }

            const reqOptions = {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(data)
            }

            const res = await fetch("http://localhost:8081/api/v1/livros/", reqOptions);

            this.showRequestAlert(res.ok);
        },
        async updateBook(e: Event) {
            e.preventDefault();

            const data = {
                titulo: this.form.titulo,
                autor: this.form.autor,
                editora: this.form.editora,
                edicao: this.form.edicao,
                idioma: this.form.idioma,
                paginas: this.form.paginas,
                genero: this.form.genero,
                status: this.form.status,
                isbn: this.form.isbn,
                ativo: this.form.ativo,
                local: this.form.local
            }

            const reqOptions = {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(data)
            };

            const res = await fetch(`http://localhost:8081/api/v1/livros/${this.form.id}`, reqOptions);

            this.showRequestAlert(res.ok);
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
  