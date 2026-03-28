import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',      // Cuando el usuario entra a la raíz
      redirect: '/tienda' // Lo mandamos automáticamente a /tienda
    },
    {
      path: '/tienda',
      name: 'tienda',
      component: () => import('@/views/TiendaView.vue')
    },
  ],
})

export default router
