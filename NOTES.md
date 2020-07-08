# Notes

1) The idea is that we build classes to model each rule type
2) The rules will be managed centrally
3) The basket will reference this centrally managed rule calculator and ask it to return the discount given the items in the basket
4) We have to be able to associate a specific rule with a specific product, so I have added a ItemType to allow this association.
5) Each rule will then filter the list of all Items and perform calculations on only the correct types.

