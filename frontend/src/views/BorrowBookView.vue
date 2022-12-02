<template>
    <main class="container w-100">
        <form class="w-100" id="form-borrow">
            <div class="row w-100">
                <div class="col w-100">
                    <div class="row w-100">
                        <div class="col-md-4 d-flex align-items-center">
                            <label class="form-label">Leitor:</label>
                        </div>
                        <div class="col-md-8">
                            <VueMultiselect v-model="form.leitor" track-by="id" label="nome" :internal-search="false"
                                :clear-on-select="false" :show-no-results="false" :close-on-select="false"
                                placeholder="Digite nome ou CPF" :loading="isLoading" :options="readers"
                                :searchable="true" @search-change="searchReaders">
                            </VueMultiselect>
                        </div>
                    </div>
                    <div class="row w-100 mt-3">
                        <div class="col-md-4 d-flex align-items-center">
                            <label class="form-label">Data de Devolução:</label>
                        </div>
                        <div class="col-md-8">
                            <input type="date" class="form-control" v-model="dataDevolucao">
                        </div>
                    </div>
                    <div class="row w-100 mt-3">
                        <div class="col-md-4 d-flex align-items-center">
                            <label class="form-label">Livro:</label>
                        </div>
                        <div class="col-md-8">
                            <SearchBar @searchResult="printSearchedBooks" :customPlaceholder="'Título, autor ou gênero'"
                                :endpoint="'livros'" />
                        </div>
                    </div>
                </div>
                <div class="col" v-show="form.itens.length != 0">
                    <div class="row">
                        <div class="col">
                            <RequestAlert class="mt-3" @showAlert="returnRequestAlert" :show="showAlert"
                                :success="alertSuccess" />
                        </div>
                        <div class="col"><button class="btn btn-secondary" @click="createBorrow">Cadastrar
                                Locação</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <BooksTable :books="borrowBooks()" @bookAction="removeBook" :showActionColumn="true" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="mt-5 w-100">
                <BooksTable :books="books" @bookAction="addBook" :showAuthorColumn="true" :showActionColumn="true"
                    :showLocalColumn="true" />
            </div>
        </form>
    </main>
</template>
  
<script lang="ts">
import { defineComponent } from 'vue';
import IBook from '@/interfaces/IBook';
import VueMultiselect from 'vue-multiselect';
import SearchBar from '@/components/SearchBar.vue';
import BooksTable from '@/components/BooksTable.vue';
import RequestAlert from '@/components/RequestAlert.vue';
import moment from 'moment';

export default defineComponent({
    name: "BooksView",
    props: {
    },
    components: { VueMultiselect, SearchBar, BooksTable, RequestAlert },
    methods: {
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
        createBorrow() {
            fetch("http://localhost:8081/api/v1/retirada", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(this.form)
            })
                .then((response) => {
                    this.showRequestAlert(response.ok);
                    return response.json();
                })
                .then(data => {
                    setTimeout(() => {
                        window.location.reload();
                    }, 2500)
                })
                .catch((error) => console.log(error));
        },
        formatDate(date: any) {
            return moment(new Date(date)).format('DD/MM/YYYY');
        },
        addBook(actionBook: any) {
            const data = {
                livro: actionBook.book,
                dataDevolucao: this.formatDate(this.dataDevolucao)
            }

            this.form.itens.push(data);
        },
        removeBook(actionBook: any) {
            this.form.itens.splice(actionBook.index, 1)
        },
        searchReaders(searchReader: string) {
            this.isLoading = true;
            fetch(`http://localhost:8081/api/v1/leitor?filtro=${searchReader}`)
                .then((response) => {
                    return response.json();
                })
                .then((data) => {
                    this.noReadersFound = data.length == 0;
                    this.readers = data;
                    this.isLoading = false;
                })
                .catch((error) => console.log(error));
        },
        printSearchedBooks(books: IBook[]) {
            this.books = books;
        },
        borrowBooks() {
            const borrBooks = this
                .form
                .itens.map(item => item.livro);
            return borrBooks;
        }
    },
    mounted() {
        var date = new Date();
        date.setDate(date.getDate() + 1);
        this.dataDevolucao = date.toISOString().slice(0, 10);

        this.form.itens.pop();
    },
    data() {
        return {
            readers: [],
            books: [] as IBook[],
            form: {
                leitor: {
                    id: ""
                },
                usuario: {
                    id: 1
                },
                dataLocacao: moment().format('DD/MM/YYYY'),
                itens: [
                    {
                        livro: {
                            id: "",
                            titulo: ""
                        },
                        dataDevolucao: ""
                    }
                ]
            },
            showAlert: false,
            alertSuccess: false,
            dataDevolucao: "",
            noReadersFound: false,
            isLoading: false
        }
    }
});
</script>
<style src="vue-multiselect/dist/vue-multiselect.css">

</style>
  
<style lang="scss">
.form-floating {
    font-size: 12px !important;

    .form-control {
        height: 40px !important;
        padding: 0 !important;

    }

    label {
        padding: 0 !important;
    }
}

.multiselect__spinner {
    border-color: #920000 !important;

    &::before {
        border-color: #920000 !important;
    }
}

.multiselect__option--highlight {
    background: #920000 !important;

    &:after {
        background: #920000 !important;
        content: "Clique para selecionar"
    }
}

.multiselect__option--selected.multiselect__option--highlight:after {
    content: "Clique para remover"
}
</style>