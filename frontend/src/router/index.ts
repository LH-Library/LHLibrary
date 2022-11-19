import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/livros',
    name: 'livros',
    component: () => import('../views/BooksView.vue')
  },
  {
    path: '/livros/novo',
    name: 'livros-novo',
    component: () => import('../views/NewBookView.vue')
  },
  {
    path: '/livros/editar/:id',
    name: 'livros-editar',
    component: () => import('../views/EditBookView.vue')
  },
  {
    path: '/livros/detalhes/:id',
    name: 'livros-detalhes',
    component: () => import('../views/DetailsBookView.vue')
  },
  {
    path: '/leitores/novo',
    name: 'leitores-novo',
    component: () => import('../views/NewReaderView.vue')
  },
  {
    path: '/leitores/editar/:id',
    name: 'leitores-editar',
    component: () => import('../views/EditReaderView.vue')
  },
  {
    path: '/leitores/detalhes/:id',
    name: 'leitores-detalhes',
    component: () => import('../views/DetailsReaderView.vue')
  },
  {
    path: '/leitores',
    name: 'leitores',
    component: () => import('../views/ReadersView.vue')
  },
  {
    path: '/locacao',
    name: 'locacao',
    component: () => import('../views/BorrowBookView.vue')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
