<template>
  <div class="card">
    <div class="card__header">
      <div class="user">
        <q-icon name="person" size="sm" />
      </div>
      <div class="card__title">
        <span class="card__buyer-name">
          {{ buyer }}
        </span>
        <span class="card__date-time">
          {{ dateTime }}
        </span>
      </div>
    </div>
    <div class="card__body">
      {{ question }}
    </div>
    <div class="card__label">Resposta</div>
    <div class="card__answer">
      {{ answer }}
    </div>
  </div>
</template>

<script>
export default {
  name: "AnsweredCard",
  props: {
    buyer: String,
    question: String,
    dateTime: String,
    answer: String
  },
  data() {
    return {
      manualAnswer: null
    };
  },
  methods: {
    onSendManualAnswer() {
      console.log("resposta manual: ", this.manualAnswer);
    }
  }
};
</script>

<style lang="scss" scoped>
.card {
  background: #30444e;
  box-shadow: 0px 1px 14px #19282f;
  border-radius: 24px;
  padding: 28px 0 16px 0;
}

.card__header {
  display: flex;
  padding: 0 16px;
}

.user {
  background: #1a5e9b;
  border-radius: 48px;
  width: 48px;
  height: 48px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  margin-right: 16px;
}

.user--talking {
  background: #3ed598;
  border-radius: 48px;
  width: 48px;
  height: 48px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  margin-right: 16px;
}

.card__title {
  display: flex;
  flex-direction: column;
  align-content: flex-start;
  justify-content: flex-start;
  text-align: left;
}

.card__buyer-name {
  color: #ffffff;
  font-size: 16px;
  font-weight: bold;
}

.card__date-time {
  font-size: 14px;
  color: #96a7af;
}

.card__body {
  margin: 8px 16px 0 16px;
  text-align: left;
  color: white;
  border-bottom: 1px solid #b8c2c0;
  mix-blend-mode: normal;
}

.card__answer {
  padding: 0 16px 0 16px;
  display: flex;
  align-items: center;
  text-align: left;
}

.card__label {
  text-align: left;
  margin: 8px 8px 8px 16px;
  color: rgba(255, 255, 255, 0.6);
}
</style>
