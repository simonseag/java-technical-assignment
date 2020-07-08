# Notes

1) The idea is that we build classes to model each rule type

2) The rules will be managed centrally

3) The basket will reference this centrally managed rule calculator and ask it to return the discount given the items in the basket

4) We have to be able to associate a specific rule with a specific product, so I have added a ItemType to allow this association.

5) Each rule will then filter the list of all Items and perform calculations on only the correct Item types.

6) Added a DiscountCalculator Module which we can add/load rules into, the basket will be able to call this to perform the discount calculation.

7) Given the limited time, I have decided to only allow a single rule per shopping item and therefore only a single rule can be added to the DiscountCalculator per item. 
For example, if we have can's of coke, loafs of bread and tins of beans, we therefore have 3 distinct types and therefore we can add 3 rules (1 per item).

8) Even though it's outside the scope of this exercise, I have ensure that a concurrent map is used within the DiscountCalculator, to ensure we can always add rules in the future whilst this component is being used.

9) The current solution has implemented 2 of the stated scenarios within the single rule FreeItemDiscountRule:
	a) Buy one, get one free
	b) Buy three items for the price of two

10) Given the time constraints I have implemented only the FreeItemDiscountRule however I have stubbed additional rules which I believe would cover the additional scenarios highlighted in the specifications. We would have to implement the calculation logic in each and the load/add them to the DiscountCalculator in the same way as the FreeItemDiscountRule.

11) This solution is extendible by implementing additional rules, each responsible for one specific discount for one specific product.

12) If we wanted to be able to apply multiple rules to a single product, this would be very possible given then current structure. The only element we would need to modify is the unique key. This is current just the ItemType enum, but we would think about combining both this and a unique element from the rule itself.

