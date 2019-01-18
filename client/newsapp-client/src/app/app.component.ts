import { Component } from '@angular/core';
import { TestService } from 'src/services/test.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'newsapp-client';
  test_message: String = '';

  constructor(private testService : TestService) { }


  ngOnInit(){
    this.testService.getTest().subscribe( value => {
      this.test_message = value;
    })
  }
}
