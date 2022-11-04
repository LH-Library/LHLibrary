import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
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
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
