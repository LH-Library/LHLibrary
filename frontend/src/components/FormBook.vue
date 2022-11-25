<template>
    <form id="form-new-book" class="w-100" novalidate>
        <div class="row">
            <div class="col">
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="titulo">Título*</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="titulo" id="titulo" v-model="form.titulo" type="text"
                            required>
                        <div class="invalid-feedback" v-for="error of v$.form.titulo.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="autor">Autor*</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="autor" id="autor" v-model="form.autor" type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.autor.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="editora">Editora*</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="editora" id="editora" v-model="form.editora" type="text"
                            required>
                        <div class="invalid-feedback" v-for="error of v$.form.editora.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="edicao">Edição*</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="edicao" id="edicao" v-model="form.edicao" type="text"
                            required>
                        <div class="invalid-feedback" v-for="error of v$.form.edicao.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="idioma">Idioma*</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="idioma" id="idioma" v-model="form.idioma" type="text"
                            required>
                        <div class="invalid-feedback" v-for="error of v$.form.idioma.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="paginas">Páginas*</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="paginas" id="paginas" v-model="form.paginas" type="number"
                            required>
                        <div class="invalid-feedback" v-for="error of v$.form.paginas.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="genero">Gênero*</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="genero" id="genero" v-model="form.genero" type="text"
                            required>
                        <div class="invalid-feedback" v-for="error of v$.form.genero.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="isbn">ISBN*</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="isbn" id="isbn" v-model="form.isbn" type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.isbn.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-md-3">
                        <label class="form-label" for="local">Local*</label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" name="local" id="local" v-model="form.local" type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.local.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-danger mt-5" v-if="form.id !== undefined"
            @click="updateBook">Atualizar</button>
        <button type="submit" class="btn btn-danger mt-5" v-else @click="createBook">Cadastrar</button>
        <RequestAlert class="mt-3" @showAlert="returnRequestAlert" :show="showAlert" :success="alertSuccess" />
    </form>
</template>
  
<script lang="ts">
import { defineComponent } from 'vue';
import RequestAlert from '@/components/RequestAlert.vue';
import { useVuelidate } from '@vuelidate/core'
import { required } from '@vuelidate/validators'

export default defineComponent({
    name: 'FormBook',
    components: { RequestAlert },
    methods: {
        goToDetailsBookPage(id: string) {
            this.$router.push({ name: 'livros-detalhes', params: { id: id } })
        },
        showRequestAlert(responseResult: boolean) {
            this.showAlert = true;
            if (!responseResult) {
                this.alertSuccess = false;
                return;
            }
            this.alertSuccess = true;
        },
        returnRequestAlert(show: boolean) {
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
        async createBook(e: Event) {
            e.preventDefault();
            const isFormCorrect = await this.v$.$validate();

            if (!isFormCorrect) {
                const formulario = document.querySelector("#form-new-book");
                formulario?.classList.add("was-validated");
                return;
            }

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
        async updateBook(e: Event) {
            e.preventDefault();
            const isFormCorrect = await this.v$.$validate();

            if (!isFormCorrect) {
                const formulario = document.querySelector("#form-new-book");
                formulario?.classList.add("was-validated");
                return;
            }

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
    setup() {
        return { v$: useVuelidate() }
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
                titulo: "",
                autor: "",
                editora: "",
                edicao: "",
                idioma: "",
                paginas: "",
                genero: "",
                status: "DISPONIVEL",
                isbn: "",
                ativo: true,
                local: ""
            },
            showAlert: false,
            alertSuccess: false
        }
    },
    validations() {
        return {
            form: {
                titulo: { required },
                autor: { required },
                editora: { required },
                edicao: { required },
                idioma: { required },
                paginas: { required },
                genero: { required },
                status: { required },
                isbn: { required },
                ativo: { required },
                local: { required }
            }
        }
    }
});
</script>
  
<style lang="scss">

</style>
  