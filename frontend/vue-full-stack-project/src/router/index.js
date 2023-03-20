import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'frontPageView',
      component: () => import('../views/FrontPageView.vue')
    },
    {
      path: '/login',
      name: 'loginPageView',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/LoginPageView.vue')
    },
    //catch all 404
    /*{
      path: '/:catchAll(.*)',  //redux pattern
      name: 'notFound',
      component: () => import('../views/NotFoundView.vue')
    }*///TODO
  ]
})

export default router
