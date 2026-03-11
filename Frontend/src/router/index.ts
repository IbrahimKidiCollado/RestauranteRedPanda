import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    /* {
      path: '/',
      name: 'inicio',
      component: InicioView
    },
    {
      path: '/carta',
      name: 'carta',
      // Carga perezosa (Lazy Loading): solo carga este código si el usuario entra aquí
      component: () => import('../views/CartaView.vue')
    },
    {
      path: '/reserva',
      name: 'reserva',
      component: () => import('../views/ReservaView.vue')
    } */
  ],
})

export default router
