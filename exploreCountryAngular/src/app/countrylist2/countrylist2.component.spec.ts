import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Countrylist2Component } from './countrylist2.component';

describe('Countrylist2Component', () => {
  let component: Countrylist2Component;
  let fixture: ComponentFixture<Countrylist2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Countrylist2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Countrylist2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
