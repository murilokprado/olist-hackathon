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
    <router-view />
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
  mounted() {
    this.tab = this.$route.path.split("/")[1];

    if (!this.tab) this.changeRoute("general");
  },
  methods: {
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
</style>
