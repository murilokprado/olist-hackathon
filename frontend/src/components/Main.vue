<template>
  <div>
    <AppHeader />
    <div class="tabs">
      <Tab
        icon="house"
        name="Geral"
        @click.native="changeRoute('general')"
        :active="isActive('general')"
      />
      <Tab
        icon="mode_comment"
        name="Mensagens"
        @click.native="changeRoute('messages')"
        :active="isActive('messages')"
      />
      <Tab
        icon="monetization_on"
        name="Din Din!"
        @click.native="changeRoute('coins')"
        :active="isActive('coins')"
      />
    </div>
    <transition name="fade" mode="out-in">
      <router-view />
    </transition>
  </div>
</template>

<script>
import AppHeader from "./AppHeader";
import Tab from "./Tab";

export default {
  name: "Main",
  components: {
    AppHeader,
    Tab
  },
  data() {
    return {
      tab: null
    };
  },
  beforeUpdate() {
    this.chooseTab();
  },
  created() {
    this.chooseTab();
  },
  methods: {
    chooseTab() {
      this.tab = this.$route.path.split("/")[1];

      if (!this.tab) return this.changeRoute("general");

      return this.changeRoute(this.tab);
    },
    changeRoute(newTab) {
      if (newTab === this.tab) return false;

      this.tab = newTab;

      this.$router.push(`/${this.tab}`);
    },
    isActive(tab) {
      return this.tab === tab;
    }
  }
};
</script>

<style scoped>
.tabs {
  padding: 0 16px;
  display: flex;
  justify-content: space-around;
}

.fade-enter-active,
.fade-leave-active {
  transition-duration: 0.1s;
  transition-property: opacity;
  transition-timing-function: ease;
}

.fade-enter,
.fade-leave-active {
  opacity: 0;
}
</style>
