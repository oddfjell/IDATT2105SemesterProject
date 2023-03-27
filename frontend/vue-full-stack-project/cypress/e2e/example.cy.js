// https://docs.cypress.io/api/introduction/api.html

describe('My First Test', () => {
  it('visits the app root url', () => {
    cy.visit('/')
    cy.contains(<Header />)
  })
})
// Deleted the other tests
// Had suddenly problem: No test files found, exiting with code 1