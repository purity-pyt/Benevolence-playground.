describe('Frontend hello and users flow', () => {
  it('loads page and can click buttons', () => {
    cy.visit('/');
    cy.contains('Benevolence Frontend');
    cy.contains('Fetch Hello').click();
    cy.contains('Users API');
  });
});
