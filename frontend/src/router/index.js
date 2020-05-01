import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import General from "../views/General.vue";
import Messages from "../views/Messages.vue";
import Coins from "../views/Coins.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
    children: [
      {
        path: "/general",
        name: "General",
        component: General
      },
      {
        path: "/messages",
        name: "Messages",
        component: Messages
      },
      {
        path: "/coins",
        name: "Coins",
        component: Coins
      }
    ]
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
