import { createRouter, createWebHistory } from 'vue-router'
import auth from "../middlewares/loginCheckAuthentication";

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
    ,
    {
      path: '/profile',
      name: 'profilePageView',
      component: () => import('../views/ProfilePageView.vue'),
      meta: {
        middleware: auth //TODO
      }
    },
    //catch all 404
    /*{
      path: '/:catchAll(.*)',  //redux pattern
      name: 'notFound',
      component: () => import('../views/NotFoundView.vue')
    }*///TODO
  ]
});//la til semikolon
/*

function nextFactory(context, middleware, index) {
  const subsequentMiddleware = middleware[index];
  if (!subsequentMiddleware) return context.next;

  return (...parameters) => {
    context.next(...parameters);
    const nextMiddleware = nextFactory(context, middleware, inde 1);
    subsequentMiddleware({ ...context, next: nextMiddleware });
  };
}

router.beforeEach((to, from, next) => {if (to.meta.middleware) {
  const middleware = Array.isArray(to.meta.middleware)
      ? to.meta.middleware
      : [to.meta.middleware];

  const context = {
    from,
    next,
    router,
    to,
  };
  const nextMiddleware = nextFactory(context, middleware, 1);

  return middleware[0]({ ...context, next: nextMiddleware });
}

return next();});


*/


export default router
