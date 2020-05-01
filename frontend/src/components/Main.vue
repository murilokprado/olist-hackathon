<template>
  <div>
    <AppHeader />
    <q-tabs class="custom-tabs" dense align="justify" v-model="tab">
      <q-tab
        name="general"
        icon="dashboard"
        label="Geral"
        @click="changeRoute('general')"
      />
      <q-tab
        name="messages"
        icon="mode_comment"
        label="Mensagens"
        @click="changeRoute('messages')"
      />
      <q-tab
        name="coins"
        icon="attach_money"
        label="O. Coins"
        @click="changeRoute('coins')"
      />
    </q-tabs>
    <router-view />
  </div>
</template>

<script>
import AppHeader from "./AppHeader";

export default {
  name: "Main",
  components: {
    AppHeader
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
    }
  }
};
</script>

<style scoped>
.custom-tabs {
  padding-top: 16px;
}
</style>
