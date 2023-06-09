# My Personal Project: Shelfie

## *Remember* what you have, be *eco-friendly* with *Shelfie*  

#### Feel inclined to stock up on products during an amazing sale?
#### Find something you forgot you had only to discover it’s now expired?  
#### Forget when you opened a product and wonder if and when it expires?

Many individuals, like myself, struggle with this problem. 
Whether it’s from over-stimulation and buying all that you can abroad (*K-beauty I’m talking about you*), 
the satisfaction of saving a few dollars during semi-annual sales (**... Sephora**), or succumbing to a trend on TikTok, 
the end often results in wasted resources: product and money.

**Thankfully**, this application is here to give structure. 
This application applies to skin-care and make-up products, so it appeals to any enthusiast. 

This app allows one to:
- Keep track of skincare and cosmetics
- Organize by brand, type, expiry date, first open date
- Provides visual reminders for expired or soiled products
- Tracks product life based on first-open date and manufacturer’s label

### On a more personal note -
This problem domain grew from my challenges with skin conditions. I constantly suffered from small
bumps, acne and scarring which made me very self-conscious growing up. Realizing and now, abiding to make-up 
cleanliness and after-opening expiry dates has cleared my skin dramatically. This is significant as bacteria 
and other microbes start to overcome preservatives by a certain period of time. If products are used beyond 
this time, it can commonly trigger skin conditions such as acne, redness and bumps. 
Following this principle over the past 4 years has brought light to my overconsumption (for reasons above), when
unopened and barely used products are often thrown away. Swept into the ebb and flow of trends in addition to 
"out of sight, out of mind" behaviours, it is estimated that I could have saved at least a thousand dollars in the
past 4 years. It makes me feel guilty thinking about what better value I could have gotten from saving or
spending elsewhere.


**To summarize**, I hope this application helps anyone with their skin, spending and confidence. At a higher level, 
I hope this application helps you be more **sustainable**.
 
## User Stories

- As a user, I want to be able to add a product to my collection.  
- As a user, I want to be able to view the list of products in my collection.  
- As a user, I want to be able to remove an expired, spoiled, or empty product from my collection.
- As a user, I want to be able to update the expiry date of a product.
- As a user, I want to be able to see the number of products in my collection. 
- As a user, I want to be able to see the products that are close to expiry.
- As a user, I want to be able to save my inventory list to file (if I so choose)
- As a user, I want to be able to load my inventory list from file (if I so choose)

## Instructions for Use

- You can generate the first required action related to adding Xs to a Y by clicking the main menu button labelled 
“Add Product”
- You can generate the second required action related to removing Xs from a Y by clicking the main menu button labelled
“Remove Product”
- You can locate my visual component by clicking the main menu button “View”
- You can save the state of my application by clicking the main menu button “Save Current Inventory”
- You can reload the state of my application by clicking the main menu button “Load Previous Inventory”


## Reflection

Shelfie should only have one inventory in existence ever. A substantive refactoring I would do is change the Inventory
class to follow the Singleton Pattern. Noticing the association arrows across classes, visualizing the coupling, 
and reflecting on the seriousness of this kind of coupling makes me realize this can be improved. My current design
leaves room for error in the case users accidentally instantiate new inventories and therefore, risk losing track of 
existing products. Implementing the Singleton Pattern will ensure that the Inventory class can only have one instance 
and provide a global point of control/access to it. To implement this pattern, I would need to create:
- A private static field of type Inventory that holds the single instance of Inventory
- A private constructor
- A public static method that allows access to the single Inventory instance

A couple disadvantages to this design include making it more difficult to test. Secondly, in the future if I wish to 
implement more functionalities such as allowing users to have different inventories for different purposes (Make-up 
versus Skin care) I would have challenges re-designing this due to this tight coupling.