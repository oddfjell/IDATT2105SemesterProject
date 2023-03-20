/*export default function checkAuth(next, isAuthenticated) {
    if (isAuthenticated) {
        next('/')
    } else {
        next('/login');
    }
}*/

export default function auth({ next, router }) {
    console.log("yey")
    /*if (!localStorage.getItem('jwt')) {
        return router.push({ name: 'login' });
    }*/
    if (true) {
        console.log("yey")
        //return router.push({ name: 'profilePageView' });
    }

    return next();
}
//TODO er bare et eksempel
// bruk i ruteren!!!!!
// burde også bli brukt i services