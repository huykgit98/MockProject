										var firstSeatLabel = 1;
									
										function loadListSeat() {
											var $cart = $('#selected-seats'),
												$counter = $('#counter'),
												$total = $('#total'),
												sc = $('#seat-map').seatCharts({
												map: [
													'ee_ee',
													'ee_ee',
													'ee_ee',
													'ee_ee',
													'eeeee',
												],
												seats: {
													f: {
														price   : 100,
														classes : 'first-class', //your custom CSS class
														category: 'First Class'
													},
													e: {
														price   : 180000,
														classes : 'economy-class', //your custom CSS class
														category: ''
													}					
												
												},
												naming : {
													top : false,
													getLabel : function (character, row, column) {
														return firstSeatLabel++;
													},
												},
												legend : {
													node : $('#legend'),
												    items : [
														[ 'e', 'available',   'Chỗ trống'],
														[ 'f', 'unavailable', 'Đã có người đặt']
												    ]					
												},
												click: function () {
													if (this.status() == 'available') {
														//let's create a new <li> which we'll add to the cart items
														$('<li style=" list-style-type: none;">'+this.data().category+this.settings.label+' <a href="#" class="cancel-cart-item">[X]</a></li>')
															.attr('id', 'cart-item-'+this.settings.id)
															.data('seatId', this.settings.id)
															.appendTo($cart);
														
														/*
														 * Lets update the counter and total
														 *
														 * .find function will not find the current seat, because it will change its stauts only after return
														 * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
														 */
														$counter.text(sc.find('selected').length+1);
														$total.text(recalculateTotal(sc)+this.data().price);
														
														return 'selected';
													} else if (this.status() == 'selected') {
														//update the counter
														$counter.text(sc.find('selected').length-1);
														//and total
														$total.text(recalculateTotal(sc)-this.data().price);
													
														//remove the item from our cart
														$('#cart-item-'+this.settings.id).remove();
													
														//seat has been vacated
														return 'available';
													} else if (this.status() == 'unavailable') {
														//seat has been already booked
														return 'unavailable';
													} else {
														return this.style();
													}
												}
											});
							
											//this will handle "[cancel]" link clicks
											$('#selected-seats').on('click', '.cancel-cart-item', function () {
												//let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
												sc.get($(this).parents('li:first').data('seatId')).click();
											});

											//let's pretend some seats have already been booked
                                   			console.log("sau khi load:",bookedseat);           
											//sc.get(bookedseat).status('unavailable');
											
									}
							
									function recalculateTotal(sc) {
										var total = 0;
									
										//basically find every selected seat and sum its price
										sc.find('selected').each(function () {
											total += this.data().price;
										});
										
										return total;
									}
									

									