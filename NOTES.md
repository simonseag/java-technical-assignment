# Notes

1) The idea is that we build classes to model each rule type
2) The rules will be managed centrally
3) The basket will reference this centrally managed rule calculator
4) We have to be able to associate a specific rule with a specific product, so I have added a ItemType to allow this association.