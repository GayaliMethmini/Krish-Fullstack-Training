import { Component, OnInit } from '@angular/core';
import { order } from '../../../common/model/order-model';
import { OrderServiceService } from '../../../common/services/order-service.service';


@Component({
  selector: 'app-fuel-order',
  templateUrl: './fuel-order.component.html',
  styleUrls: ['./fuel-order.component.css']
})
export class FuelOrderComponent implements OnInit {

  order ={} as order ;
  newOrder={} as order;
  orderId: String | undefined;

  constructor(private orderService:OrderServiceService) { }

  ngOnInit(): void {

  }
  submitOrder(){

    this.orderService.saveOrder(this.order).subscribe(data => {

      this.newOrder = data
      this.orderId= this.newOrder.orderId;
      alert('Order ID is: '+ this.orderId);
      console.log(this.orderId);
      //this.refreshPeople();
    })
    console.log(this.order);
  }
}
