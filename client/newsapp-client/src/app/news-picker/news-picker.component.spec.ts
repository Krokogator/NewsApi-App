import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsPickerComponent } from './news-picker.component';

describe('NewsPickerComponent', () => {
  let component: NewsPickerComponent;
  let fixture: ComponentFixture<NewsPickerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewsPickerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsPickerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
