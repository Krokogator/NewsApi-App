import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsCategoryPickerComponent } from './news-category-picker.component';

describe('NewsCategoryPickerComponent', () => {
  let component: NewsCategoryPickerComponent;
  let fixture: ComponentFixture<NewsCategoryPickerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewsCategoryPickerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsCategoryPickerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
