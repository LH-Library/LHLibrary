<template>
    <form id="form-new-book" class="w-100">
        <div class="row">
            <div class="col">
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="nome">Nome</label>
                    </div>
                    <div class="col-9">
                        <input class="form-control" name="nome" id="nome" v-model="form.nome" type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.nome.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="email">E-mail</label>
                    </div>
                    <div class="col-9">
                        <input class="form-control" name="email" id="email" v-model="form.email" type="email" required>
                        <div class="invalid-feedback" v-for="error of v$.form.email.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="telefone">Telefone</label>
                    </div>
                    <div class="col-9">
                        <input class="form-control" name="telefone" id="telefone" v-model="form.telefone" type="tel" required>
                        <div class="invalid-feedback" v-for="error of v$.form.telefone.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="cpf">CPF</label>
                    </div>
                    <div class="col-9">
                        <input class="form-control" name="cpf" id="cpf" v-model="form.cpf" type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.cpf.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="logradouro">Logradouro</label>
                    </div>
                    <div class="col-6">
                        <input class="form-control" name="logradouro" id="logradouro" v-model="form.endereco.logradouro"
                            type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.endereco.logradouro.$errors"
                            :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                    <div class="col-1">
                        <label class="form-label" for="numero">Nº</label>
                    </div>
                    <div class="col-2">
                        <input class="form-control" name="numero" id="numero" v-model="form.endereco.numero"
                            type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.endereco.numero.$errors"
                            :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="bairro">Bairro</label>
                    </div>
                    <div class="col-9">
                        <input class="form-control" name="bairro" id="bairro" v-model="form.endereco.bairro"
                            type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.endereco.bairro.$errors"
                            :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="complemento">Complemento</label>
                    </div>
                    <div class="col-9">
                        <input class="form-control" name="complemento" id="complemento"
                            v-model="form.endereco.complemento" type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.endereco.complemento.$errors"
                            :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="cidade">Cidade</label>
                    </div>
                    <div class="col-9">
                        <input class="form-control" name="cidade" id="cidade" v-model="form.endereco.cidade"
                            type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.endereco.cidade.$errors"
                            :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
                <div class="row g-3 align-items-center mt-3">
                    <div class="col-3">
                        <label class="form-label" for="cep">CEP</label>
                    </div>
                    <div class="col-9">
                        <input class="form-control" name="cep" id="cep" v-model="form.endereco.cep" type="text" required>
                        <div class="invalid-feedback" v-for="error of v$.form.endereco.cep.$errors" :key="error.$uid">
                            {{ error.$message }}
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-danger mt-5" v-if="form.id !== undefined"
            @click="updateReader">Atualizar</button>
        <button type="submit" class="btn btn-danger mt-5" v-else @click="createReader">Enviar</button>
        <RequestAlert class="mt-3" @showAlert="returnRequestAlert" :show="showAlert" :success="alertSuccess" />
    </form>
</template>
  
<script lang="ts">
import { defineComponent } from 'vue';
import RequestAlert from '@/components/RequestAlert.vue';
import { useVuelidate } from '@vuelidate/core'
import { required, email } from '@vuelidate/validators'


export default defineComponent({
    name: 'FormReader',
    components: { RequestAlert },
    methods: {
        goToDetailsReaderPage(id: string) {
            this.$router.push({ name: 'leitores-detalhes', params: { id: id } })
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
        getReaderInformation(id: string | string[]) {
            fetch(`http://localhost:8081/api/v1/leitor/${id}`)
                .then((response) => {
                    return response.json();
                })
                .then((data) => this.form = data)
                .catch((error) => console.log(error));
        },
        async createReader(e: Event) {
            e.preventDefault();
            const isFormCorrect = await this.v$.$validate();

            if (!isFormCorrect) {
                const formulario = document.querySelector("#form-new-book");
                formulario?.classList.add("was-validated");
                return;
            }

            fetch("http://localhost:8081/api/v1/leitor/", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(this.form)
            })
                .then((response) => {
                    this.showRequestAlert(response.ok);
                    return response.json();
                })
                .then((data) => this.goToDetailsReaderPage(data.id))
                .catch((error) => console.log(error));
        },
        async updateReader(e: Event) {
            e.preventDefault();
            const isFormCorrect = await this.v$.$validate();

            if (!isFormCorrect) {
                const formulario = document.querySelector("#form-new-book");
                formulario?.classList.add("was-validated");
                return;
            }
            fetch(`http://localhost:8081/api/v1/leitor/${this.form.id}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(this.form)
            })
                .then((response) => {
                    this.showRequestAlert(response.ok);
                    return response.json();
                })
                .then((data) => this.goToDetailsReaderPage(data.id))
                .catch((error) => console.log(error));
        }
    },
    setup() {
        return { v$: useVuelidate() }
    },
    mounted() {
        if (this.form.id != null) {
            this.getReaderInformation(this.form.id);
        }
    },
    data() {
        return {
            form: {
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
            showAlert: false,
            alertSuccess: false
        }
    },
    validations() {
        return {
            form: {
                nome: { required },
                email: { required, email },
                cpf: { required },
                telefone: { required },
                ativo: { required },
                endereco: {
                    logradouro: { required },
                    cep: { required },
                    bairro: { required },
                    numero: { required },
                    cidade: { required },
                    complemento: { required }
                }
            }
        }
    }
});
</script>
  
<style lang="scss">

</style>
  