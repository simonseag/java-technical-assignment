# Notes

1) The idea is that we build classes to model each rule type

2) The rules will be managed centrally

3) The basket will reference this centrally managed rule calculator and ask it to return the discount given the items in the basket

4) We have to be able to associate a specific rule with a specific product, so I have added a ItemType to allow this association.

5) Each rule will then filter the list of all Items and perform calculations on only the correct Item types.

6) Added a DiscountCalculator Module which we can add/load rules into, the basket will be able to call this to perform the discount calculation.

7) Given the limited time, I have decided to only allow one rule per shopping item and therefore only one rule can be added to the DiscountCalculator per item. 
For example, if we have can's of coke, loafs of bread and tins of beans, we therefore have 3 distinct types and therefore we can add 3 rules (1 per item).

8) Even though it's outside the scope of this exercise, I have ensure that a concurrent map is used within the DiscountCalculator, to ensure we can always add rules in the future whilst this component is being used.

