Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Простой тест с Given
    Given browser is started

  Scenario: Простой тест с Given и When
    Given browser is started
    When login page is opened

  Scenario: Простой тест со всеми основными словами
    Given browser is started
    When login page is opened
    Then username field is displayed