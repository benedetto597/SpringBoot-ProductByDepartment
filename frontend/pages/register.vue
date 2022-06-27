<template>
  <form @submit.prevent="submit">
    <div justify="center" align="center">
        <h1 class="h3 mb-3 fw-normal">Register</h1>
    
        <input v-model="name" class="form-control" placeholder="Name" required>
    
        <input v-model="last_name" class="form-control" placeholder="Last Name" required>
    
        <input v-model="email" type="email" class="form-control" placeholder="Email" required>
    
        <input v-model="password" type="password" class="form-control" placeholder="Password" required>
    
        <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
    </div>
  </form>
</template>

<script>
export default {
  name: "register",
  data() {
    return {
      name: '',
      last_name: '',
      email: '',
      password: ''
    }
  },
  methods: {
    async submit() {
        await axios({
            method: 'post',
            url: 'http://localhost:8080/user/createUser',
            data: {
                name: this.name,
                last_name: this.last_name,
                email: this.email,
                password: this.password
            },
            headers: {
                'Content-Type': 'application/json'
            }
        });
       
      await this.$router.push('/login');
    }
  }
}
</script>