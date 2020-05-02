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
    <div class="card__buttons">
      <div class="card__button" @click="$emit('afirmative')">
        Sim, existe.
      </div>
      <div class="card__button" @click="$emit('negative')">
        Não existe.
      </div>
    </div>
    <div class="card__answer">
      <div class="user--talking">
        <q-icon name="record_voice_over" size="sm" />
      </div>
      <q-input
        style="flex: 1"
        filled
        dark
        dense
        v-model="manualAnswer"
        placeholder="Personalize sua resposta. Escreva aqui"
        @keyup.enter="onSendManualAnswer"
      />
    </div>
  </div>
</template>

<script>
export default {
  name: "WaitingReturnCard",
  props: {
    buyer: String,
    question: String,
    dateTime: String
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

.card__buttons {
  padding: 16px 16px 0 16px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}

.card__button {
  color: white;
  margin-right: 16px;
  border: 1.6px solid white;
  border-radius: 40px;
  padding: 8px 16px;
  background: rgba(255, 255, 255, 0.1);
  cursor: pointer;
}

.card__button:hover {
  background: rgba(255, 255, 255, 0.3);
}

.card__answer {
  margin-top: 8px;
  padding: 8px 16px 0 16px;
  border-top: 1px solid #b8c2c0;
  display: flex;
  align-items: center;
}
</style>
