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
      path: '/register',
      name: 'RegisterPageView',
      component: () => import('../views/RegisterPageView.vue')
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
    },
    {
      path: '/newad',
      name: 'NewAdView',
      component: () => import('../views/NewAdView.vue')
    },
    //catch all 404
    {
      path: '/:catchAll(.*)',  //redux pattern
      name: 'notFound',
      component: () => import('../views/404View.vue')
    }
  ]
});

export default router
