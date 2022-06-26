export const state = () => ({
    id: 0,
    name: "",
    email: "",
    password: "",
    created_at: "",
    updated_at: ""
})

export const mutations = {
    storeId:(state, data) => {
        state.id = data
    },
    storeName:(state, data) => {
        state.name = data
    },
    storeEmail:(state, data) => {
        state.name = data
    },
    storePassword:(state, data) => {
        state.password = data
    },
    storeCreatedAt:(state, data) => {
        state.created_at = data
    },
    storeUpdatedAt:(state, data) => {
        state.updated_at = data
    }
}