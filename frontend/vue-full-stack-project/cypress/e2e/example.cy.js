// https://docs.cypress.io/api/introduction/api.html

describe('My First Test', () => {
  it('visits the app root url', () => {
    cy.visit('/')
    cy.contains('h1', 'You did it!')
  })
})


describe('My First Test', () => {
  it('visits the app root url', () => {
    cy.visit('/')
    cy.contains('h1', 'ELO')
  })
})


describe('My second Test', () => {
  it('visits the app root url', () => {
    cy.visit('/')
    cy.get('[class="wrapper"]')
        .children()
        .children()
        .should('have.length', 4)
    //cy.contains('h1', 'ELO')
  })
})

describe('Able button', () => {
  it('should able the button', () => {
    cy.visit('/contact')
    cy.get('input[data-cy="name"]').type('John');
    cy.get('input[data-cy="email"]').type('john@example.com');
    cy.get('textarea[data-cy="fb"]').type('This is my feedback');
    cy.get('input[type="checkbox"]').check();
    cy.get('div[type="submit"]').click()
    cy.wait(10)
    cy.get('button[data-cy="send"]').should('not.be.disabled')
  })
})


describe('Disable button', () => {
  it('should disable the button if the strings are empty', () => {
    cy.visit('/contact')
    cy.get('input[data-cy="name"]').should('have.text', '')
    cy.get('input[type="checkbox"]').uncheck();
    cy.get('div[type="submit"]').click()
    cy.get('button[data-cy="send"]').should('be.disabled')
  }) //diabeled lagde jeg bare for testing pga annen løsning i koden
})



describe('ItemView', () => {
  beforeEach(() => {
    cy.visit('/item/1') // assuming that the component is rendered on the /item/1 route
  })

  it('renders the item details properly', () => {
    cy.get('#title').should('exist')
    cy.get('#image img').should('exist')
    cy.get('#brief-description').should('exist')
    cy.get('#full-description').should('exist')
    cy.get('#price').should('exist')
  })

  it('renders the seller details properly', () => {
    cy.get('#seller-name').should('exist')
    cy.get('#seller-email').should('exist')
    cy.get('#seller-address').should('exist')
  })

  it('does not render the seller details if seller data is not available', () => {
    // assuming that the seller and address data are null by default
    cy.get('#seller-name').should('not.exist')
    cy.get('#seller-email').should('not.exist')
    cy.get('#seller-address').should('not.exist')
  })

  it('calls addToCart method when AddToCart button is clicked', () => {
    cy.get('#buyBtn').click()
    cy.on('window:alert', (str) => {
      expect(str).to.equal('You added Item 1 Title to the cart')
    })
  })
})
