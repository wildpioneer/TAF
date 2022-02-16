Feature: Более сложный тест

  Scenario: Использования AND в Given
    Given browser is started
    And login page is opened
    When user logged in
    Then add project button is displayed

  Scenario: Параметризация
    Given browser is started
    And login page is opened
    When user "atrostyanko+0401@gmail.com" with password "QqtRK9elseEfAk6ilYcJ" logged in
    Then add project button is displayed
    And username is "Alex Tros"

  Scenario Outline: Таблицы
    Given browser is started
    And login page is opened
    When user "<username>" with password "<password>" logged in
    Then add project button is displayed
    And username is "<visibleText>"

    Examples:
      | username                           | password             | visibleText  |
      | atrostyanko+0401@gmail.com         | QqtRK9elseEfAk6ilYcJ | Alex Tros    |
      | atrostyanko+StandardUser@gmail.com | 1234567              | StandardUser |
