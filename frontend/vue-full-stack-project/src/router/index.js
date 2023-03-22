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
      component: () => import('../views/LoginPageView.vue')
    },
    {
      path: '/profile',
      name: 'profilePageView',
      //TODO if auth fra store
      component: () => import('../views/ProfilePageView.vue'),
    },
    {
      path:'/item',
      name:'itemView',
      component: ()=> import('../views/ItemView.vue'),

    }
    //catch all 404
    /*{
      path: '/:catchAll(.*)',  //redux pattern
      name: 'notFound',
      component: () => import('../views/NotFoundView.vue')
    }*///TODO
  ]
});//la til semikolon

export default router
