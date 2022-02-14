Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Простой тест с Given
    Given browser is started 1

  Scenario: Простой тест с Given и When
    Given browser is started 1
    When login page is opened 1

  Scenario: Простой тест со всеми основными словами
    Given browser is started 1
    When login page is opened 1
    Then username field is displayed 1