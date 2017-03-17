Feature: Bank Account calculator
  Background:
    Given User is on Bank Account calculator page
  Scenario: Which could give the best return
    When User clicks on which could give the best return and
    Then User clicks on Saving Account calculator
    And Fill below details for best return
      |Initial_Deposit | Ongoing_SavingAmount |Ongoing_SavingFrequency|Saving_PeriodYear |Saving_PeriodMonth|Interest_Rte|
      |80000           |  5000                | Monthly               | 8                |5                | 33%        |
    Then Saving Account earning details are displayed with and without tax
      |Dep_Int_Bef_Tax | Tax_On_In  |Dep_Int_Aft_Tax|
      |$585,000.00     | $0.00      | $585,000      |
  Scenario: How long will it take you to reach your goal
    When User clicks on How long will it take you to reach your goal
    And Fill below details for goal
      |Target_Amount | Saved_Already |Put_Aside_Regularly|Frequency   |Saving_Account                 |Tax_Rte|
      |80000         |  2000         | 1000              | Fortnightly|Online Bonus Saver - 2.40% p.a.|17.5   |
    Then Time to reach goal calculated details are displayed
      |Time_To_Reach_Goal |
      |2 years 11 months  |


